import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-hospede-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormHospedeComponent implements OnInit {
  title = 'Form Hospede';

  constructor() {
  }

  ngOnInit(): void {
  }
}
