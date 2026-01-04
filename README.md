# webtech-backend
## Projektbeschreibung
Diese Applikation ist ein Shop-Backend-Manager. Sie ermöglicht das Verwalten von Produkten.

### Implementierte Use-Cases:
1. **Produkt anlegen**: Neue Produkte mit Name und Preis speichern.
2. **Produktliste anzeigen**: Übersicht aller gespeicherten Produkte.
3. **Produktdetails**: Einzelansicht der Objektdaten.
4. **Produkt löschen**: Entfernen von Einträgen aus der Datenbank.
5. **Produkt bearbeiten**: Aktualisieren von bestehenden Produktdaten (Update).
6. **Suchen**: Filtern der Liste nach Namen über die API.
7. **Filtern**: Einschränken der Ansicht nach einem Maximalpreis.


## Installation & Start
### Backend
1. Navigiere in den Backend-Ordner.
2. Starte die App mit: `./mvnw spring-boot:run`

### Frontend
1. Navigiere in den Frontend-Ordner.
2. Installiere Abhängigkeiten: `npm install`
3. Starte den Development-Server: `npm run dev`

## Deployment URL
Backend App: https://webtech-backend-6ot9.onrender.com
https://webtech-backend-6ot9.onrender.com/api/products
srv-d4kaf7u3jp1c738ncrfg
Frontend App: https://webtech-frontend-6w6z.onrender.com
srv-d4kbmd2li9vc73dlnt9g

## Datenbank
External Database URL: postgresql://webtech_db_neu_user:NGICUI5gX0e7jKgLkI4C76EBpjopF9E3@dpg-d5dcjmuuk2gs738tj82g-a.frankfurt-postgres.render.com/webtech_db_neu
Internal Database URL: postgresql://webtech_db_neu_user:NGICUI5gX0e7jKgLkI4C76EBpjopF9E3@dpg-d5dcjmuuk2gs738tj82g-a/webtech_db_neu
Username: webtech_db_neu_user
Hostname: dpg-d5dcjmuuk2gs738tj82g-a
Password: NGICUI5gX0e7jKgLkI4C76EBpjopF9E3
Database: webtech_db_neu
Port: 5432