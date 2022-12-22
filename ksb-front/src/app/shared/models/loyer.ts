import { Employee } from "./employee";
import { Locataire } from "./locataire";
import { Propriete } from "./propriete";

export class Loyer {
    UUID !: String;
    id !: string
    montant !: number;
    dateDebut !: Date
    dateFin !: Date
    dernierPaiement !: Date
    mensualite !: number
    dateProchainPaiement !: Date
    caution !: number
    propriete !: Propriete
    locataire !: Locataire
    employee !: Employee
}