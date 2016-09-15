INSERT INTO Aanestys(Tunnus, aanestysNimi, Kuvaus) VALUES(?, ?, ?);

INSERT INTO Vaihtoehto(VaihtoehtoNimi, AanestysID) VALUES(?,?);

INSERT INTO Aani(VaihtoehtoID, AanestysID) VALUES(?,?);

SELECT v.VaihtoehtoNimi, COUNT(ai.AaniID) AS '��ni�' FROM Aani ai JOIN Vaihtoehto v ON v.VaihtoehtoID=ai.VaihtoehtoID GROUP BY ai.VaihtoehtoID;

SELECT a.Tunnus, a.AanestysNimi, COUNT(ai.AaniID) AS '��nien summa' FROM Aani ai JOIN Aanestys a ON a.AanestysID=ai.AanestysID;