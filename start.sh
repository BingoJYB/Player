#!/bin/bash

mvn clean
mvn package
echo -e '#!/bin/bash\n java -jar target/player-0.0.1.jar "other player"' > temp.sh
chmod a+x temp.sh
./temp.sh &
java -jar target/player-0.0.1.jar initiator