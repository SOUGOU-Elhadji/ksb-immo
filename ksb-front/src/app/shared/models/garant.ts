import { SituationProfessionnelle } from "./situation-professionnelle";

export class Garant {

    UUID !: String;
    cni !: String;
    dateDelivranceCni !: Date;
    nom !: String;
    prenom !: String;
    adresse !: String;
    telephone !: String;
    email !: String;
    profession !: String;
    situationProfessionnelle !: SituationProfessionnelle;
}
