import { Garant } from "./garant";
import { Loyer } from "./loyer";
import { SituationProfessionnelle } from "./situation-professionnelle";
import { Utilisateur } from "./utilisateur";

export class Locataire extends Utilisateur {
    id!: number;
    nom!: string;
    prenom!: string;
    adresse!: string;
    telephone!: string;
    email!: string;
    profession!: string;
    numCompteBancaire !: String;
    situationProfessionnelle !: SituationProfessionnelle;
    garant!: Garant;
    loyer !: Loyer;
}
