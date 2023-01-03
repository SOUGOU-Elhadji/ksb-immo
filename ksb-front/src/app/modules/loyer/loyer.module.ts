import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { LoyerNonPayesComponent } from './loyer-non-payes/loyer-non-payes.component';
import { NgxPaginationModule } from 'ngx-pagination';



@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    NgxPaginationModule
  ],
})
export class LoyerModule { }
