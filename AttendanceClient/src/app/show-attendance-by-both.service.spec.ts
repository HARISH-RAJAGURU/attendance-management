import { TestBed } from '@angular/core/testing';

import { ShowAttendanceByBothService } from './show-attendance-by-both.service';

describe('ShowAttendanceByBothService', () => {
  let service: ShowAttendanceByBothService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowAttendanceByBothService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
