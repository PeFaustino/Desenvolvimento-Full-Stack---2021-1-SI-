import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Hospedagem} from '../../../../model/hospedagem.model';
import {HospedagemService} from '../../../../service/hospedagem.service';
import {Quarto} from '../../../../model/quarto.model';
import {Hospede} from '../../../../model/hospede.model';
import {HospedeService} from '../../../../service/hospede.service';
import {QuartoService} from '../../../../service/quarto.service';

@Component({
  selector: 'app-hospedagem-update',
  templateUrl: '../hospedagem-form/hospedagem-form.component.html',
  styleUrls: ['../hospedagem-form/hospedagem-form.component.css']
})
export class HospedagemUpdateComponent implements OnInit {

  titulo = 'Alterar dados da Hospedagem';
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
    private route: ActivatedRoute,
    private service: HospedagemService,
    private hospedeService: HospedeService,
    private quartoService: QuartoService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id != null) {
      this.service.findById(id).subscribe(hospedagem => {
        this.hospedagem = hospedagem;
      });
    }
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
    this.service.update(this.hospedagem).subscribe(() => {
      this.service.showMessage('Hospedagem atualizado sucesso!');
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
