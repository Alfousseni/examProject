import { Component, inject, OnInit } from '@angular/core';
import {
  NzModalComponent,
  NzModalModule,
  NzModalService,
} from 'ng-zorro-antd/modal';
import { NzButtonComponent, NzButtonModule } from 'ng-zorro-antd/button';
import { NzFlexModule } from 'ng-zorro-antd/flex';
import { StudentResponse } from './models/student-response';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { StudentService } from './services/student.service';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-students',
  standalone: true,
  imports: [
    NzModalModule,
    NzButtonModule,
    NzFlexModule,
    NzDividerModule,
    NzTableModule,
    NzDropDownModule,
    NzIconModule,
  ],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css',
})
export class StudentsComponent implements OnInit {
  isVisible = false;
  tableLoading = false;
  currentRecord: StudentResponse | null = null;
  modalService = inject(NzModalService);
  studentService = inject(StudentService);
  private readonly message = inject(NzMessageService);
  listStudents: StudentResponse[] = [];

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents() {
    this.tableLoading = true;
    this.studentService.all<StudentResponse[]>('api/v1/students').subscribe({
      next: (data) => {
        this.listStudents = data;
      },
      error: (error) => {
        console.log(error);
      },
      complete: () => {
        console.log('traitement termine.');
        this.tableLoading = false;
      },
    });
  }

  addStudent(): void {
    this.isVisible = true;
    this.currentRecord = null;
  }

  updateStudent(course: StudentResponse) {
    this.isVisible = true;
    this.currentRecord = course;
  }

  deleteStudent(id: number) {
    this.modalService.confirm({
      nzTitle: 'Suppression',
      nzContent: 'Etes-vous sûr de vouloir supprimer cet étudiant ?',
      nzOkText: 'Oui',
      nzOkType: 'primary',
      nzOkDanger: true,
      nzOnOk: () => {
        this.studentService.delete(`api/v1/students`, id).subscribe({
          next: () => {
            this.message.success(`Etudiant ${id} supprimé avec succès`);
            this.loadStudents();
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            console.log('traitement termine.');
          },
        });
      },
      nzCancelText: 'Non',
      nzOnCancel: () => console.log('Cancel'),
    });
  }

  handleCancel(): void {
    this.isVisible = false;
  }
}
