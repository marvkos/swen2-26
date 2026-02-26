import { Component, signal } from '@angular/core';
import { SearchInput } from '../components/search/search-input';

@Component({
  selector: 'app-root',
  imports: [SearchInput],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('SWEN1');
}
