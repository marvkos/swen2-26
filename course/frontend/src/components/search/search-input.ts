import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SearchInputViewModel } from './search-input.vm';

@Component({
  selector: 'search-input',
  templateUrl: './search-input.html',
  imports: [FormsModule],
  providers: [SearchInputViewModel],
})
export class SearchInput {
  vm = inject(SearchInputViewModel);
}
