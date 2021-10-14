import {Hospede} from './hospede.model';
import {Quarto} from './quarto.model';

export interface Hospedagem {
  idHospedagem?: number;
  hospede: Hospede;
  quarto: Quarto;
  dtCheckin: Date;
  dtCheckout: Date;
}
