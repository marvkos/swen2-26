import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { forkJoin, map, Observable } from 'rxjs';
import { Character, Movie, SwapiFilm, SwapiPerson } from './swapi.models';

@Injectable({ providedIn: 'root' })
export class SwapiService {
  private readonly http = inject(HttpClient);
  private readonly baseUrl = 'https://swapi.info/api';

  /** Map raw API film → domain Movie */
  private toMovie(film: SwapiFilm): Movie {
    return {
      episodeId: film.episode_id,
      title: film.title,
      releaseYear: new Date(film.release_date).getFullYear(),
      characterUrls: film.characters,
    };
  }

  /** Map raw API person → domain Character */
  private toCharacter(p: SwapiPerson): Character {
    return {
      name: p.name,
    };
  }

  /** Fetch all films, sorted by episode */
  getMovies(): Observable<Movie[]> {
    return this.http
      .get<SwapiFilm[]>(`${this.baseUrl}/films/`)
      .pipe(
        map((res) => res.map((f) => this.toMovie(f)).sort((a, b) => a.episodeId - b.episodeId)),
      );
  }

  /** Fetch a single person by URL (as returned by the films API) */
  getCharacter(url: string): Observable<Character> {
    return this.http.get<SwapiPerson>(url).pipe(map((p) => this.toCharacter(p)));
  }

  /** Fetch all people for a movie in parallel */
  getCharacterForMovie(movie: Movie): Observable<Character[]> {
    const requests = movie.characterUrls.map((url) => this.getCharacter(url));
    return forkJoin(requests);
  }
}
