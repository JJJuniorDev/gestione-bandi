import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaturaUserForm } from './candidatura-user-form';

describe('CandidaturaUserForm', () => {
  let component: CandidaturaUserForm;
  let fixture: ComponentFixture<CandidaturaUserForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaturaUserForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidaturaUserForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
