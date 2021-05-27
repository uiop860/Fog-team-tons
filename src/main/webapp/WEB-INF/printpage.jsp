<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:printtag>

    <jsp:attribute name="header">
        Print tilbud
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-2 pt-3 pb-3 ">
                    <button class="noprint btn btn-primary" onclick="window.print()">Print tilbud</button>
                </div>
                <div class="col-sm-2 pt-3 pb-3 ">
                    <form action="${pageContext.request.contextPath}/fc/managefsp" method="post">
                        <button name="manageRequest" value="${requestScope.request.requestID}"
                                class="noprint btn btn-primary">Gå tilbage
                        </button>
                    </form>
                </div>
                <div class="col-sm-4"></div>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-md-4">
                    <table class="table">
                        <thead>
                        <th scope="col">Materiale</th>
                        <th scope="col">Beskrivelse</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Pris</th>
                        </thead>
                        <c:forEach var="material" items="${requestScope.materialList}">
                            <tr>
                                <td>${material.material_name}</td>
                                <td>${material.description}</td>
                                <td>${material.amount}</td>
                                <td>${material.total_material_price} kr.</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <h3 class="text-center">Total pris: ${requestScope.request.total_price} kr.</h3>

                </div>
                <div class="col-sm-4"></div>
            </div>

            <div class="pb-3">
                <div class="card">
                    <div class="card-header text-center bg-primary">
                        <div class="fs-2 text-light">
                            Skitse ovenfra
                        </div>
                    </div>
                    <div class="pt-4">
                            ${requestScope.SVG}
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-header text-center bg-primary">
                    <div class="fs-2 text-light">
                        Skitse fra siden
                    </div>
                </div>
                <div class="pt-4">
                        ${requestScope.sideSvg}
                </div>
            </div>


        </div>
        <div class="row pt-5">
            <h1>Byggevejledning</h1>
            <p>Husk ved modtagelse, at kontrollere de leverede materialer i forhold til styklisten.</p>

            <div class="col-sm-6">
                <h3>1.</h3>
                <p>Grundplan afsættes ved at hamre en stump lægte (A) i jorden til ca. markering af carportens
                    hjørnestolper, en pæl i hvert hjørne. Stolpe placering kan ses på tegning.</p>
            </div>

            <div class="col-sm-6">
                <img src="${pageContext.request.contextPath}/resources/vejledning_one.png">
            </div>

            <h3>2.</h3>
            <p>Ca. 30cm ud for markeringen opsættes en galje (B) ca. 30.cm høj over jorden. Her holdes en afstand af 20
                cm fra jordhøjde til overkant af tværbræt galje. Brug vaterpas. Det vil lette arbejdet senere hvis de 4
                tværbrædder er i samme højde, afsæt højden fra det ene tværbræt til det næste med et langt lige bræt og
                vaterpas.</p>

            <h3>3.</h3>
            <p>En muresnor (C) hæftes ovenpå tværbrætet - flugtende med lægtestumpen til markering af hjørnestolper. Her
                hamres søm i overkant af tværbræt, til at spænde snor fast på, hvilket gøres på alle fire sider, så der
                fremkommer et rektangel imellem galjerne.</p>

            <h3>4.</h3>
            <p>Derefter tages diagonalmål (D) som SKAL være det samme mål på begge diagonaler. Når diagonalmålet er det
                samme på begge diagonaler er det afsatte mål i vinkel. Det er vigtigt disse er i vinkel.</p>


            <h3>5.</h3>
            <p>Nu skal stolpehuller bores i jorden. Brug et pælebor som passer til stolpernes tykkelse, samt en
                pælespade. Bemærk ydersiden af stolpen (E) skal flugte snoren (C). Hullerne bores max 90 cm dybe
                i fronten og max 100 cm dybe bagtil hvilket giver fald på tagfladen. Husk at bundsikre så stolpe
                ikke sætter sig. Forreste stolper skal være 208 cm. Høje og bagerste skal være 202 cm. Kan evt.
                skæres til efter montering af rem. Husk at tage højde for, hvis terrænet skråner.</p>

            <div class="pagebreak">
                <img src="${pageContext.request.contextPath}/resources/vejledning_two.png">
            </div>


            <h3>6.</h3>
            <p><b>Montering af stolper:</b> Placer stolper, og kontroller at disse er lodrette og stamp tæt til med
                blanding af
                jord og sten. Det kan lette arbejdet, hvis stolperne afstives med to skråstivere når de er placeret og
                oprettet derved er det nemmere at holde placeringen, når hullerne omkring stolperne fyldes. Ønskes
                ekstra stabilitet kan her også støbes med tørbeton/vand, eller cement-grus-sten blanding i forhold
                1:4:4. (eller cement/grus i forhold 1:8)+vand så blandingen er jordfugtig.</p>
            <p><b>Bemærk at stolper er imprægneret til montering direkte i jord</b></p>

            <h3>7.</h3>
            <p><b>Udskæring i stolpen til remmen:</b> Remmen levers i spærtræ 45x195 mm. Når stolper er monteret, Skæres
                et
                hak/blad udvendig i toppen af hver stolpe (E) til remmen (F) Der skal skæres ud, så remmen flugter eller
                er lidt højere end toppen af stolpen, Så remmen får et fald bagud på carporten. Dette gøres nemmest ved
                at holde remmen op mod stolpen og fast holde med en skrue tvinge. Sæt højden på oversiden af remmen ved
                forreste stolpe til, 209 cm. (Ved plan grund) og sænke bagenden til 200 cm. ved bagerste stolpe,
                derefter kan der streges op på stolperne, så får du lavet et saddelhakket med fald på. Bemærk at faldet
                kan øges hvis man ønsker det, ved at sænke bagenden.</p>
            <p>Læg remmen i udskæringen på toppen af stolperne (fasthold evt. med skruetvinger under monteringen) og bor
                hul til bræddebolte, 2 stk. pr. stolpe, som monteres fra udvendig side, skive og møtrik spændes på
                indersiden. Bemærk at remmen samles af 2 stykker, over den stole der er mellem skur og carport,
                Samlingen centreres over stolpen og der anvendes i alt 4 bolte til denne samling. Vær opmærksom på, at
                træet kan have pilhøjde, dvs. at træet buer svagt, Kontroller og placer remmen så evt. pilhøjde er opad.
                Træet leveres på fod mål, dvs. længde kan variere få cm. Og skal renskæres på mål før opsætning.</p>

            <div class="pagebreak">
                <img src="${pageContext.request.contextPath}/resources/vejledning_three.png">
            </div>

            <h3>8.</h3>
            <p><b>Montering af spær beslag:</b> Universal/spær beslag til fastgørelse af spær på rem. Start med at
                opmærke på
                oversiden af remmene, hvor det forreste og det bagerste spær skal placeres. Opmærk på begge sidder af
                hvert spær, spæret skal senere placeres imellem disse to streger. Der opmærkes på samme måde til de
                mellemliggende spær. Afstanden mellem spærene skal være ens, max 60 cm. Montér universalbeslagene med
                vinklen mod bagsiden af spær/ovenpå rem, og fladen på indvendigt side af rem. (se tegning) Alle beslag
                monteres med 3 beslags skruer pr. flade i beslaget. Vær opmærksom på at der er højre og venstre beslag.
                Ved det bagerste spær monteres beslaget på spærets forside af hensyn til stern eller beklædning.</p>

            <div class="pagebreak">
                <img src="${pageContext.request.contextPath}/resources/vejledning_four.png">
            </div>

            <h3>9.</h3>
            <p><b>Montering af spær:</b> Start med at kontrollere alle spær for pilhøjde, og renskær på mål. Spær længde
                tilpasses til 5950 mm. På grund af dobbelt stern. 2 x 25 mm. Som monteres, så den flugter overkant spær.
                Monter først det forreste og det bagerste spær, og mål nøjagtigt ud ved udhæng så der er samme afstand i
                begge sider. Træk en mursnor fra enden af spærene på den lange led af carporten. De mellemliggende spær
                monteres, så de passer med snoren, hvilket sikrer lige langt udhæng. Hvis spærene skal males kan det
                anbefales at gøre dette inden opsætning.</p>
            <p><b>(Bemærk at spærene, hvis de males, skal males i en lys farve på oversiden)</b></p>

            <h3>10.</h3>
            <p><b>Montering af hulbånd:</b> Hulbåndet monteres som vist på tegningen. Start med at fastgøre i den ene
                ende oven på spær, træk over til den anden side over spærene og stram op før fastgørelse, hvilken
                foregår med 1-2 beslags skruer i de spær der krydses. Pas på ved opstramningen at carporten ikke trækkes
                ud af vinkel, kontroller evt. diagonalmålet på toppen af stolperne, før skrues sømmes fast. Vær også
                opmærksom på, at spæret kan “kæntre”, afstiv evt. med ekstra beslag.</p>

            <h3>11.</h3>
            <p><b>Montering af Stern:</b> Start med understernbræt (25 x 200 mm) som skal sidde på det forreste spær
                (den høje ende). Afkort det så det har samme længde som spæret plus 5.cm. Monter sternbrættet så det er
                2,5 cm længere end spæret i hver side og sternbrættets overkant flugter med spæret. De to under
                Sternbrædder i siderne monteres ligeledes så de flugter overkant af spærene, og skrues fast i enderne af
                spærene. Længden tilpasses individuelt afhængig af om der monteres tagrende. <b>(tagrende medfølger
                    ikke)</b></p>
            <p>Det bagerste under sternbræt afkortes og tilpasses så det passer imellem de to side sternbrædder, og
                skrues fast på bagerste spær. <b>Bemærk</b>: Overkant bagerste sternbræt skal også være lig med overkant
                af bagerste spær. Her efter kan over sternen (25x125) monteres, på forenden, samt sider, men skal
                placeres 30 mm. Højere end spærene, således at trapez taget bliver skjult.</p>

            <h3>12.</h3>
            <p><b>Montering af Trapez plader:</b> Start med at lægge pladerne løst op, så de når ud til sternbrædderne i
                sider og front, bagerst skal pladerne række ca. 5 cm ud over sternbrættet, med henblik på afvanding.
                Pladerne fordeles så de har et overlæg på min 2 bølger. <b>Bemærk</b> at plader er delt i længde
                retningen, start med de korte plader i skurdelen, og lad de lange plader overlappe de korte, således at
                overlægget kommer i faldretningen.</p>
            <p><b>(Tilpasning sker bedst med en vinkelsliber)</b> Pladerne fastgøres med de leverede montageskruer, til
                montering i bunden. Se vejledning fra Plastmo.</p>

            <h3>13.</h3>
            <p><b>Afslutning:</b> På toppen af sternbrædderne i front og sider monteres et vandbrædt (19x100) som beskyttelse og overlap mellem tagplader og sternbræt.</p>

            <div>
            <h2>GOD ARBEJDSLYST</h2>
            <p><b>Anbefalet værktøj: </b></p>
                <ul>
                    <li>Vaterpas</li>
                    <li>Hammer</li>
                    <li>Skruemaskine</li>
                    <li>Sav</li>
                    <li>Boremaskine</li>
                    <li>Mursnor</li>
                    <li>Vinkel</li>
                    <li>Wienerstige</li>
                    <li>Pælebor</li>
                    <li>Træbor 12mm</li>
                    <li>Skruetvinger</li>
                    <li>Spade</li>
                    <li>Skiftenøgle</li>
                </ul>
            </div>
            <div class="col-sm-6 row">
                <div class="col-sm-3">
                    <button class="noprint btn btn-primary" onclick="window.print()">Print tilbud</button>
                </div>
                <div class="col-sm-3">
                    <form action="${pageContext.request.contextPath}/fc/managefsp" method="post">
                        <button name="manageRequest" value="${requestScope.request.requestID}"
                                class="noprint btn btn-primary">Gå tilbage
                        </button>
                    </form>
                </div>

            </div>
            <div class="col-sm-6">

            </div>
        </div>
        <div>
    </jsp:body>
</t:printtag>