import { Component, inject, OnInit } from '@angular/core';
import { MoviesStateService } from '../movies.state';
import { Movie } from '../swapi.models';

@Component({
  selector: 'movies-list',
  templateUrl: './movies-list.html',
})
export class MoviesList implements OnInit {
  readonly state = inject(MoviesStateService);

  ngOnInit(): void {
    this.state.loadMovies();
  }

  selectMovie(movie: Movie): void {
    this.state.selectMovie(movie);
  }

  isSelected(movie: Movie): boolean {
    return this.state.selectedMovie()?.episodeId === movie.episodeId;
  }

  episodeLabel(id: number): string {
    const numerals: Record<number, string> = {
      1: 'I',
      2: 'II',
      3: 'III',
      4: 'IV',
      5: 'V',
      6: 'VI',
    };
    return numerals[id] ?? String(id);
  }
}
