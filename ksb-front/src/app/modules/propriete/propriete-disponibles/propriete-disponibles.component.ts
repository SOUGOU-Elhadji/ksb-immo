import { ToastrService } from 'ngx-toastr';
import { ProprieteDto } from './../../../shared/dts/propriete-dto';
import { ProprieteService } from './../../../shared/services/propriete.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-propriete-disponibles',
  templateUrl: './propriete-disponibles.component.html',
  styleUrls: ['./propriete-disponibles.component.css']
})
export class ProprieteDisponiblesComponent implements OnInit {
  proprietes !: ProprieteDto[]
  term: any;
  p: number = 1;

  constructor(private service : ProprieteService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getProprieteDisponibles();
  }

  private getProprieteDisponibles(){
    this.service.getProprieteDisponibles().subscribe(
      data => {
        this.proprietes = data;
      },
      error => {
        this.showInfo();
      }
    )
  }

  private showInfo() {
    this.toastr.info('Aucune propriété en Location', 'Info' , {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'decreasing',
      positionClass: 'toast-bottom-right'
    });
  }

  search() {

  }
}
