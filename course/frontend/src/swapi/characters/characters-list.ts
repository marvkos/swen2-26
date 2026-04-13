import { Component, inject } from '@angular/core';
import { MoviesStateService } from '../movies.state';

@Component({
  selector: 'characters-list',
  templateUrl: './characters-list.html',
})
export class CharactersList {
  readonly state = inject(MoviesStateService);
}
