import { Locataire } from "./locataire";
import { Propriete } from "./propriete";

export class Loyer {
    id !: string
    mensualite !: number;
    dateDebut !: Date
    dateFin !: Date
    dernierPaiement !: Date
    dateProchainPaiement !: Date
    caution !: number
    montant !: number
    propriete !: Propriete
    locataire !: Locataire
}