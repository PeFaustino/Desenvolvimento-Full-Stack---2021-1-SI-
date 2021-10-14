import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Observable} from 'rxjs';
import {Hospedagem} from '../model/hospedagem.model';


@Injectable({
  providedIn: 'root'
})
export class HospedagemService {

  urlBase = 'http://localhost:8080/hospedagem';

  constructor(
    private http: HttpClient,
    private snackBar: MatSnackBar
  ) {
  }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'Fechar',
      {
        verticalPosition: 'top',
        horizontalPosition: 'right',
        duration: 3000,
        panelClass: isError ? ['msg-error'] : ['msg-success']
      }
    );
  }

  // CREATE
  create(hospedagem: Hospedagem): Observable<Hospedagem> {
    return this.http.post<Hospedagem>(this.urlBase, hospedagem);
  }

  // READ
  // findAll
  findAll(): Observable<Hospedagem[]> {
    return this.http.get<Hospedagem[]>(this.urlBase);
  }

  // findById
  findById(id: string): Observable<Hospedagem> {
    const url = `${this.urlBase}/${id}`;
    return this.http.get<Hospedagem>(url);
  }

  // UPDATE
  update(hospedagem: Hospedagem): Observable<Hospedagem> {
    return this.http.put<Hospedagem>(this.urlBase, hospedagem);
  }


  // DELETE

  delete(hospedagem: Hospedagem): Observable<Hospedagem> {
    const url = `${this.urlBase}/${hospedagem.idHospedagem}`;
    console.log(url);
    return this.http.delete<Hospedagem>(url);
  }
}
