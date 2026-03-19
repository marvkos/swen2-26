import { computed, inject, Injectable, signal } from '@angular/core';
import { Character, Movie } from './swapi.models';
import { SwapiService } from './swapi.service';

export type LoadingState = 'idle' | 'loading' | 'success' | 'error';

@Injectable({ providedIn: 'root' })
export class MoviesStateService {
  private readonly swapiService = inject(SwapiService);

  // --- Private writable signals ---
  private readonly _movies = signal<Movie[]>([]);
  private readonly _selectedMovie = signal<Movie | null>(null);
  private readonly _characters = signal<Character[]>([]);
  private readonly _moviesStatus = signal<LoadingState>('idle');
  private readonly _characterStatus = signal<LoadingState>('idle');

  // --- Public read-only signals ---
  readonly movies = this._movies.asReadonly();
  readonly selectedMovie = this._selectedMovie.asReadonly();
  readonly characters = this._characters.asReadonly();
  readonly moviesStatus = this._moviesStatus.asReadonly();
  readonly characterStatus = this._characterStatus.asReadonly();

  // --- Computed signals ---
  readonly isLoadingMovies = computed(() => this._moviesStatus() === 'loading');
  readonly isLoadingCharacter = computed(() => this._characterStatus() === 'loading');
  readonly hasMovieSelected = computed(() => this._selectedMovie() !== null);

  /** Load all movies into state */
  loadMovies(): void {
    this._moviesStatus.set('loading');
    this.swapiService.getMovies().subscribe({
      next: (movies) => {
        console.log(movies);
        this._movies.set(movies);
        this._moviesStatus.set('success');
      },
      error: (error) => {
        console.log(error);
        this._moviesStatus.set('error');
      },
    });
  }

  /** Select a movie and load its characters */
  selectMovie(movie: Movie): void {
    // Avoid redundant fetch
    if (this._selectedMovie()?.episodeId === movie.episodeId) return;

    this._selectedMovie.set(movie);
    this._characters.set([]);
    this._characterStatus.set('loading');

    this.swapiService.getCharacterForMovie(movie).subscribe({
      next: (character) => {
        this._characters.set(character);
        this._characterStatus.set('success');
      },
      error: () => this._characterStatus.set('error'),
    });
  }

  clearSelection(): void {
    this._selectedMovie.set(null);
    this._characters.set([]);
    this._characterStatus.set('idle');
  }
}
