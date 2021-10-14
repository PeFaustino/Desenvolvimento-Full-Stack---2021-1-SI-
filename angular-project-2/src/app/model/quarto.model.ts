import {Hotel} from './hotel.model';
import {CategoriaQuarto} from './categoria-quarto.enum';

export interface Quarto {
  idQuarto?: number;
  hotel: Hotel;
  categoriaQuarto: CategoriaQuarto;
  qtdLeito: number;
  nrQuarto: number;
  prDiaria: number;
}
