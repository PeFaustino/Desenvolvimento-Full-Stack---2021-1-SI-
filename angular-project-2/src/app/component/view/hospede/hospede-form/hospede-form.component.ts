import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Hospede} from '../../../../model/hospede.model';
import {HospedeService} from '../../../../service/hospede.service';

@Component({
  selector: 'app-hospede-form',
  templateUrl: './hospede-form.component.html',
  styleUrls: ['./hospede-form.component.css']
})
export class HospedeFormComponent implements OnInit {

  titulo = 'Cadastrar novo Hospede';

  hospede: Hospede = {
    nmHospede: '',
    cpf: 0,
    dtNascimento: new Date()
  };

  constructor(
    private service: HospedeService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
  }

  salvar(): void {
    this.service.create(this.hospede).subscribe(() => {
      this.service.showMessage('Hospede cadastro com sucesso!');
      this.router.navigate(['/hospedes']);
    });
  }

}
