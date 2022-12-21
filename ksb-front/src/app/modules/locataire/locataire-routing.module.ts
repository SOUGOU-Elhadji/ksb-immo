import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateLocataireComponent } from './create-locataire/create-locataire.component';

const routes: Routes = [
  // {path: 'create-locataire', component: CreateLocataireComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LocataireRoutingModule { }
