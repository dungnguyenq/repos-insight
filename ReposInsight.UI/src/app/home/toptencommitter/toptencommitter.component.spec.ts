import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToptencommitterComponent } from './toptencommitter.component';

describe('ToptencommitterComponent', () => {
  let component: ToptencommitterComponent;
  let fixture: ComponentFixture<ToptencommitterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToptencommitterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ToptencommitterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
