import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CommitOverPeriodTimeComponent } from './commitoverperiodtime.component';

describe('CommitOverPeriodTimeComponent', () => {
  let component: CommitOverPeriodTimeComponent;
  let fixture: ComponentFixture<CommitOverPeriodTimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommitOverPeriodTimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CommitOverPeriodTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
