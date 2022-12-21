import { FormatDatePipe } from 'src/app/shared/pipe/format-date.pipe';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoyerPayesComponent } from './loyer-payes/loyer-payes.component';



@NgModule({
  declarations: [
    FormatDatePipe
  ],
  imports: [
    CommonModule
  ],
})
export class LoyerModule { }
