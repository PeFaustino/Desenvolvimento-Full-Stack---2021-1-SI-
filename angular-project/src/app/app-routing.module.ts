import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MenuComponent} from "./pages/menu/menu.component";
import {HospedeComponent} from "./pages/hospede/hospede.component";
import {FormHospedeComponent} from "./pages/hospede/form/form.component";
import {HospedagemComponent} from "./pages/hospedagem/hospedagem.component";
import {FormHospedagemComponent} from "./pages/hospedagem/form/form.component";


const routes: Routes = [
  {path: '', component: MenuComponent},
  {path: 'hospede', component: HospedeComponent},
  {path: 'hospede/form', component: FormHospedeComponent},
  {path: 'hospedagem', component: HospedagemComponent},
  {path: 'hospedagem/form', component: FormHospedagemComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
