import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LanguagebreakComponent } from './languagebreak.component';

describe('LanguagebreakComponent', () => {
  let component: LanguagebreakComponent;
  let fixture: ComponentFixture<LanguagebreakComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LanguagebreakComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LanguagebreakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
