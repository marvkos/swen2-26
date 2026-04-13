import { Component, signal } from '@angular/core';
import { SearchInput } from '../components/search/search-input';
import { ItemList } from '../components/selectable-items/item-list';
import { ThreeValues } from '../components/three-values/three-values';
import { CharactersList } from '../swapi/characters/characters-list';
import { MoviesList } from '../swapi/movies/movies-list';

@Component({
  selector: 'app-root',
  imports: [SearchInput, ThreeValues, ItemList, MoviesList, CharactersList],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('SWEN1');
}
