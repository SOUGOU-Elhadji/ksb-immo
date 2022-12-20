import { EmployeeDto } from 'src/app/shared/dts/employee-dto';

export class AgenceDto {
    id!: string;
    nom!: string;
    adresse!: string;
    region!: string;
    departement!: string;
    telephone!: string;
    employees!: EmployeeDto[];
}
