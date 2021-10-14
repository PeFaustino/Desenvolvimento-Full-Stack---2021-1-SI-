import {ConfirmDeleteComponent} from '../../../template/confirm-delete/confirm-delete.component';
import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Hospedagem} from '../../../../model/hospedagem.model';
import {HospedagemService} from '../../../../service/hospedagem.service';

@Component({
  selector: 'app-hospedagem-list',
  templateUrl: './hospedagem-list.component.html',
  styleUrls: ['./hospedagem-list.component.css']
})
export class HospedagemListComponent implements OnInit {

  hospedagem: Hospedagem[] = [];
  displayedColumns: string[] = ['id', 'nome', 'quarto', 'checkin', 'checkout', 'acao'];

  constructor(
    private service: HospedagemService,
    private dialog: MatDialog
  ) {
  }

  atualizarDados(): void {
    this.service.findAll().subscribe(hospedagem => {
      this.hospedagem = hospedagem;
    });
  }

  ngOnInit(): void {
    this.atualizarDados();
  }

  excluir(hospedagem: Hospedagem): void {

    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir a hospedagem ${hospedagem.idHospedagem}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Desistir'
        }
      }
    });

    dialogRef.afterClosed().subscribe((confirm: boolean) => {
      if (confirm) {
        this.service.delete(hospedagem).subscribe(() => {
          this.service.showMessage('Hospedagem excluída com sucesso!');
          this.atualizarDados();
        });
      }
    });

  }

}
