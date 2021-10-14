import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HospedeService} from '../../../../service/hospede.service';
import {Hospedagem} from '../../../../model/hospedagem.model';
import {HospedagemService} from '../../../../service/hospedagem.service';
import {QuartoService} from '../../../../service/quarto.service';
import {Quarto} from '../../../../model/quarto.model';
import {Hospede} from '../../../../model/hospede.model';

@Component({
  selector: 'app-hospedagem-form',
  templateUrl: './hospedagem-form.component.html',
  styleUrls: ['./hospedagem-form.component.css']
})
export class HospedagemFormComponent implements OnInit {

  titulo = 'Cadastrar nova Hospedagem';

  quartos: Quarto[] = [];
  hospedes: Hospede[] = [];

  hospedagem: Hospedagem = {
    hospede: {
      cpf: 0,
      dtNascimento: new Date(),
      idHospede: 0,
      nmHospede: '',
    },
    dtCheckin: new Date(),
    dtCheckout: new Date(),
    quarto: {
      hotel: {
        nmHotel: '',
        endereco: '',
        qtdEstrelas: 0,
      },
      categoriaQuarto: 0,
      qtdLeito: 0,
      nrQuarto: 0,
      prDiaria: 0,
    }
  };

  constructor(
    private service: HospedagemService,
    private hospedeService: HospedeService,
    private quartoService: QuartoService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getQuartos();
    this.getHospedes();
  }

  getQuartos(): void {
    this.quartoService.findAll().subscribe( res => {
      this.quartos = res;
    });
  }

  getHospedes(): void {
    this.hospedeService.findAll().subscribe( res => {
      this.hospedes = res;
    });
  }

  salvar(): void {
    console.log(this.hospedagem);
    this.service.create(this.hospedagem).subscribe(() => {
      this.service.showMessage('Hospedagem cadastro com sucesso!');
      this.router.navigate(['/hospedagem']);
    });
  }

  setHospede(hospede: Hospede): void {
    this.hospedagem.hospede = hospede;
    console.log(this.hospedagem.hospede);
  }

  setQuarto(quarto: Quarto): void {
    this.hospedagem.quarto = quarto;
    console.log(this.hospedagem.quarto);
  }

}
