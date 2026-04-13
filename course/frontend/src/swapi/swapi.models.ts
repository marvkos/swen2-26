// Raw API response shapes
export interface SwapiFilm {
  title: string;
  episode_id: number;
  release_date: string; // "YYYY-MM-DD"
  characters: string[]; // URLs
  url: string;
}

export interface SwapiPerson {
  name: string;
  url: string;
}

// Domain models (what our demo works with)
export interface Movie {
  episodeId: number;
  title: string;
  releaseYear: number;
  characterUrls: string[];
}

export interface Character {
  name: string;
}
