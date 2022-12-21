import { Locataire } from "./locataire";
import { Propriete } from "./propriete";

export class Loyer {
    mensualite !: number;
    dateDebut !: Date
    dateFin !: Date
    dateDernierPaiement !: Date
    dateProchainPaiement !: Date
    caution !: number
    montant !: number
    propriete !: Propriete
    locataire !: Locataire
}