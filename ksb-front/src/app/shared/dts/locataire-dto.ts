import { LoyerDto } from './loyer-dto';
import { SituationProfessionnelle } from 'src/app/shared/models/situation-professionnelle';

export class LocataireDto {
  id !: number;
  nom !: string;
  prenom !: string;
  telephone !: string;
  email !: string;
  adresse !: string;
  cni !: string;
  dateDelivranceCni !: string;
  numCompteBancaire !: string;
  situationProfessionnelle !: SituationProfessionnelle;
  loyer !: LoyerDto
  proprieteId !: string;
}