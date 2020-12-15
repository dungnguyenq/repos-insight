import {NgModule} from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  exports: [
    MatGridListModule,
    MatListModule,
    MatSelectModule,
    MatButtonModule
  ]
})
export class MaterialModule {}