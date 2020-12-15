import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CommitOverPeriodTimeComponent } from './home/commitoverperiodtime/commitoverperiodtime.component';
import { ToptencommitterComponent } from './home/toptencommitter/toptencommitter.component';
import { LanguagebreakComponent } from './home/languagebreak/languagebreak.component';
import {MaterialModule } from './home/material-module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import { ChartsModule } from 'ng2-charts';


@NgModule({
  exports: [
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    CommitOverPeriodTimeComponent,
    ToptencommitterComponent,
    LanguagebreakComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
