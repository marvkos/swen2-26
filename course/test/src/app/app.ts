import { Component, signal } from '@angular/core';
import { SearchInput } from '../components/search/search-input';
import { ThreeValues } from '../components/three-values/three-values';

@Component({
  selector: 'app-root',
  imports: [SearchInput, ThreeValues],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('SWEN1');
}
