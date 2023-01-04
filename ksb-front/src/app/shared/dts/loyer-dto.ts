import { ProprieteDto } from 'src/app/shared/dts/propriete-dto';

export class LoyerDto {
    mensualite !: number;
    dateDebut !: string
    dureeBail !: number
    caution !: number
    propriete !: ProprieteDto
}