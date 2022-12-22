import { Employee } from "./employee";
import { Locataire } from "./locataire";
import { Propriete } from "./propriete";

export class Loyer {
    UUID !: String;
    montant !: number;
    dateDebut !: Date
    dateFin !: Date
    dateDernierPaiement !: Date
    dateProchainPaiement !: Date
    caution !: number
    mensualite !: number;
    propriete !: Propriete
    locataire !: Locataire
    employee !: Employee
}