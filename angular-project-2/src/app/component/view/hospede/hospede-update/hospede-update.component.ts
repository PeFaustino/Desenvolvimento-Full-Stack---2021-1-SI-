import {Hospede} from '../../../../model/hospede.model';
import {HospedeService} from '../../../../service/hospede.service';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-hospede-update',
  templateUrl: '../hospede-form/hospede-form.component.html',
  styleUrls: ['../hospede-form/hospede-form.component.css']
})
export class HospedeUpdateComponent implements OnInit {

  titulo = 'Alterar dados do Hospede';

  hospede: Hospede = {
    nmHospede: '',
    cpf: 0,
    dtNascimento: new Date()
  };

  constructor(
    private route: ActivatedRoute,
    private service: HospedeService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id != null) {
      this.service.findById(id).subscribe(hospede => {
        this.hospede = hospede;
      });
    }
  }

  salvar(): void {
    this.service.update(this.hospede).subscribe(() => {
      this.service.showMessage('Hospede atualizado sucesso!');
      this.router.navigate(['/hospedes']);
    });
  }
}
