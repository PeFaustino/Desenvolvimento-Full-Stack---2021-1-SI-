import { HotelUpdateComponent } from './component/view/hotel/hotel-update/hotel-update.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/view/home/home.component';
import { HotelFormComponent } from './component/view/hotel/hotel-form/hotel-form.component';
import { HotelListComponent } from './component/view/hotel/hotel-list/hotel-list.component';
import { QuartoFormComponent } from './component/view/quarto/quarto-form/quarto-form.component';
import { QuartoListComponent } from './component/view/quarto/quarto-list/quarto-list.component';
import {HospedeListComponent} from './component/view/hospede/hospede-list/hospede-list.component';
import {HospedeFormComponent} from './component/view/hospede/hospede-form/hospede-form.component';
import {HospedeUpdateComponent} from './component/view/hospede/hospede-update/hospede-update.component';
import {HospedagemListComponent} from './component/view/hospedagem/hospedagem-list/hospedagem-list.component';
import {HospedagemFormComponent} from './component/view/hospedagem/hospedagem-form/hospedagem-form.component';
import {HospedagemUpdateComponent} from './component/view/hospedagem/hospedagem-update/hospedagem-update.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'hoteis', component: HotelListComponent},
  {path: 'hoteis/form', component: HotelFormComponent},
  {path: 'hoteis/:id', component: HotelUpdateComponent},
  {path: 'hospedes', component: HospedeListComponent},
  {path: 'hospedes/form', component: HospedeFormComponent},
  {path: 'hospedes/:id', component: HospedeUpdateComponent},
  {path: 'hospedagem', component: HospedagemListComponent},
  {path: 'hospedagem/form', component: HospedagemFormComponent},
  {path: 'hospedagem/:id', component: HospedagemUpdateComponent},
  {path: 'quartos', component: QuartoListComponent},
  {path: 'quartos/form', component: QuartoFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
