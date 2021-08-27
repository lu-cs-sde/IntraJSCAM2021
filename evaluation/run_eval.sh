#!/bin/zsh

# Author: Idriss Riouak 
# Date: 29/01/2021
# E-mail: idriss.riouak@cs.lth.se

### Setting the environment
 . ~/.sdkman/bin/sdkman-init.sh
 sdk use java 7.0.292-zulu
if [[ `uname` != "Darwin" ]]; then
    alias gdate="date"
    alias start_sq="sh sonarqube_npa/bin/linux-x86-64/sonar.sh console &"
else
    alias start_sq="sh sonarqube_npa/bin/macosx-universal-64/sonar.sh console &"
fi
set -e

TIMEFMT=$'U'
TEST_DIR=$1
FILES=($TEST_DIR/**/*.java)
N_ITER=$2
N_ITER_SS=$3
PROJECT=$4
PRJECTDIR=$5
CLASSPATH=$6
CURRDIR=$7

echo '\u001b[33;1m[INFO] STARTING ANALYSING PROJECT '$PROJECT' \u001b[0m'

alias INTRAJ="java  -jar  ../intraj.jar -classpath "$CLASSPATH
alias INTRAJ_BL="java  -jar  ../intraj_bl.jar -classpath "$CLASSPATH
alias INTRAJ_DDA="java  -jar  ../intraj_daa.jar -classpath "$CLASSPATH
alias INTRAJ_NPA="java -jar ../intraj_npa.jar -excludelit -classpath "$CLASSPATH
alias INTRAJ_CFGNPA="java -jar ../intraj_cfgnpa.jar -excludelit -classpath "$CLASSPATH
alias INTRAJ_CFG="java  -jar  ../intraj_cfg.jar -classpath "$CLASSPATH
alias INTRAJ_CFGDDA="java  -jar  ../intraj_cfgdaa.jar -classpath "$CLASSPATH
alias JJI="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JavaDeadAssignChecker -classpath "$CLASSPATH
alias JJI_BL="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI -classpath "$CLASSPATH
alias JJI_DDA="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_DDA -classpath "$CLASSPATH
alias JJI_CFG="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_CFG -classpath "$CLASSPATH
alias JJI_CFGDDA="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_CFGDDA -classpath "$CLASSPATH


echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_DDA) \u001b[0m'
export intraj_daa=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_DDA $FILES)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_daa+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation  (INTRAJ_DDA) '$N_ITER_SS' iters \u001b[0m'
export intraj_daa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_DDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_daa_ss+=($RESULT)
done

############################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFG) \u001b[0m'
export intraj_cfg=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_CFG $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_cfg+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation  (INTRAJ_CFG) '$N_ITER_SS' iters \u001b[0m'
export intraj_cfg_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_CFG $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_cfg_ss+=($RESULT)
done

##########################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGDDA) \u001b[0m'
export intraj_cfgdaa=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_CFGDDA $FILES)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_cfgdaa+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGDDA) '$N_ITER_SS' iters \u001b[0m'
export intraj_cfgdaa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_CFGDDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_cfgdaa_ss+=($RESULT)
done



#################################### NPA ################################### 
echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_NPA) \u001b[0m'
 export intraj_npa=()
 for a in {1..$N_ITER}
 do
  sleep 1
  START=$(gdate +%s.%N)
  (INTRAJ_NPA $FILES)
  END=$(gdate +%s.%N)
  PROC_TIME=$(echo "$END - $START" | bc)
  echo $DIFF
  echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
  intraj_npa+=($PROC_TIME)
 done


echo '\u001b[33;1m[INFO] Running Time performance evaluation  (INTRAJ_NPA) '$N_ITER_SS' iters \u001b[0m'
export intraj_npa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_NPA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_npa_ss+=($RESULT)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGNPA) \u001b[0m'
 export intraj_cfgnpa=()
 for a in {1..$N_ITER}
 do
  sleep 1
  START=$(gdate +%s.%N)
  (INTRAJ_CFGNPA $FILES)
  END=$(gdate +%s.%N)
  PROC_TIME=$(echo "$END - $START" | bc)
  echo $DIFF
  echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
  intraj_cfgnpa+=($PROC_TIME)
 done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGNPA) '$N_ITER_SS' iters \u001b[0m'
export intraj_cfgnpa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_CFGNPA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_cfgnpa_ss+=($RESULT)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_DDA) \u001b[0m'
export jji_dda=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_DDA $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_dda+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_DDA) '$N_ITER_SS' iters \u001b[0m'
export jji_dda_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_DDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_dda_ss+=($RESULT)
done

############################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFG) \u001b[0m'
export jji_cfg=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_CFG $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_cfg+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFG)'$N_ITER_SS' iters \u001b[0m'
export jji_cfg_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_CFG $FILES  -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_cfg_ss+=($RESULT)
done

##########################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFGDDA) \u001b[0m'
export jji_cfgdda=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_CFGDDA $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_cfgdda+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFGDDA) '$N_ITER_SS' iters \u001b[0m'
export jji_cfgdda_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_CFGDDA $FILES  -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_cfgdda_ss+=($RESULT)
done


echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_BL) \u001b[0m'
export intraj_bl=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_BL $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_bl+=($PROC_TIME)
done


echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_BL) \u001b[0m'
export jji_bl=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_BL $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_bl+=($PROC_TIME)
done




echo '\u001b[33;1m[INFO] Results DAA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_daa
echo '\u001b[33;1m[INFO] Results DAA (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_daa_ss
echo '\u001b[33;1m[INFO] Results CFG (start up) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfg
echo '\u001b[33;1m[INFO] Results CFG (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfg_ss
echo '\u001b[33;1m[INFO] Results CFGDDA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgdaa
echo '\u001b[33;1m[INFO] Results CFGDDA (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgdaa_ss
echo '\u001b[33;1m[INFO] Results Baseline'$N_ITER_SS ' iters \u001b[0m'
echo $intraj_bl
echo '\u001b[33;1m[INFO] Results NPA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_npa
echo '\u001b[33;1m[INFO] Results NPA (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_npa_ss
echo '\u001b[33;1m[INFO] Results CFGNPA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgnpa
echo '\u001b[33;1m[INFO] Results CFGNPA (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgnpa_ss


echo '\u001b[33;1m[INFO] Results JJI_DDA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $jji_dda
echo '\u001b[33;1m[INFO] Results JJI_DDA (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $jji_dda_ss
echo '\u001b[33;1m[INFO] Results JJI_CFG (start up) '$N_ITER_SS' iters \u001b[0m'
echo $jji_cfg
echo '\u001b[33;1m[INFO] Results JJI_CFG (stady state) '$N_ITER_SS' iters \u001b[0m'
echo $jji_cfg_ss
echo '\u001b[33;1m[INFO] Results JJI_CFGDDA (start up) '$N_ITER_SS' iters \u001b[0m'
echo $jji_cfgdda
echo '\u001b[33;1m[INFO] Results JJI_CFGDDA (stady state)' $N_ITER_SS' iters \u001b[0m'
echo $jji_cfgdda_ss





PROJECT_DIR=$CURRDIR/$PROJECT
mkdir $PROJECT_DIR

echo '\u001b[33;1m[INFO] Executing and saving the warnings on files (INTRAJ_NH_DDA) \u001b[0m'
INTRAJ $FILES -WDAA -statistics  -txt-output> "$PROJECT_DIR/INTRAJ_NH_DAA.txt"
echo '\u001b[33;1m[INFO] Executing and saving the warnings on files (INTRAJ_H_DDA) \u001b[0m'
INTRAJ $FILES -WDAA -statistics -excludelit -txt-output> "$PROJECT_DIR/INTRAJ_H_DAA.txt"
echo '\u001b[33;1m[INFO] Executing and saving the warnings on files (INTRAJ_NPA) \u001b[0m'
INTRAJ $FILES -WNPA -statistics -txt-output> "$PROJECT_DIR/INTRAJ_NPA.txt"
echo '\u001b[33;1m[INFO] Executing and saving the warnings on files (JJI_DAA) \u001b[0m'
JJI $FILES > "$PROJECT_DIR/JJI_DAA.txt"


sdk use java 11.0.9.fx-zulu
echo '\u001b[33;1m[INFO] Starting Sonarqube Server. The log is printed on std input \u001b[0m'
echo '\u001b[33;1m[INFO] The warnings detected by SQ on the different projects are printed on the std input \u001b[0m'
echo '\u001b[33;1m[INFO] Please just ignore them \u001b[0m'
start_sq
# sh sonarqube_dda/bin/macosx-universal-64/sonar.sh console &
# sh sonarqube_dda/bin/linux-x86-64/sonar.sh console &
sleep 30s
cd $PRJECTDIR
echo '\u001b[33;1m[INFO] Running Time performance evaluation (SQ_DDA) \u001b[0m'
for a in {1..$N_ITER}
do
 sleep 1
 ./gradlew sonarqube  -Dsonar.projectKey=ANTLR -Dsonar.host.url=http://localhost:9000  -Dsonar.login=8422c25278e6129e370c9c49758fc2e7e8b549eb  -q -DfileName=../"$PROJECT_DIR/SQ_DDA.txt"
 echo "\u001b[34;1m--------Iteration "$a" -------->> \u001b[0m"
done

input=../"$PROJECT_DIR/SQ_DDA.txt"
export sq_dda=()
while IFS= read -r line
do
 sq_dda+=($line)
done < "$input"

cd ..
pkill wrapper
sleep 20s

echo '\u001b[33;1m[INFO] Starting Sonarqube Server. The log is printed on std input \u001b[0m'
echo '\u001b[33;1m[INFO] The warnings detected by SQ on the different projects are printed on the std input \u001b[0m'
echo '\u001b[33;1m[INFO] Please just ignore them \u001b[0m'
start_sq
# sh sonarqube_npa/bin/macosx-universal-64/sonar.sh console &
# sh sonarqube_npa/bin/linux-x86-64/sonar.sh console&
sleep 30s
cd $PRJECTDIR
echo '\u001b[33;1m[INFO] Running Time performance evaluation (SQ_NPA) \u001b[0m'
for a in {1..$N_ITER}
do
 sleep 1
 ./gradlew sonarqube  -Dsonar.projectKey=ANTLR -Dsonar.host.url=http://localhost:9000  -Dsonar.login=8422c25278e6129e370c9c49758fc2e7e8b549eb  -q -DfileName=../"$PROJECT_DIR/SQ_NPA.txt"
 echo "\u001b[34;1m--------Iteration "$a" -------->> \u001b[0m"
done

input=../"$PROJECT_DIR/SQ_NPA.txt"
export sq_npa=()
while IFS= read -r line
do
 sq_npa+=($line)
done < "$input"
cd ..
pkill wrapper
sleep 20s

echo '\u001b[33;1m[INFO] Starting Sonarqube Server. The log is printed on std input \u001b[0m'
echo '\u001b[33;1m[INFO] The warnings detected by SQ on the different projects are printed on the std input \u001b[0m'
echo '\u001b[33;1m[INFO] Please just ignore them \u001b[0m'
start_sq
# sh sonarqube_npa/bin/macosx-universal-64/sonar.sh console &
# sh sonarqube_npa/bin/linux-x86-64/sonar.sh console&
sleep 30s
cd $PRJECTDIR
echo '\u001b[33;1m[INFO] Running Time performance evaluation (SQ_BL) \u001b[0m'
for a in {1..$N_ITER}
do
 sleep 1
 ./gradlew sonarqube  -Dsonar.projectKey=ANTLR -Dsonar.host.url=http://localhost:9000  -Dsonar.login=8422c25278e6129e370c9c49758fc2e7e8b549eb  -q -DfileName=../"$PROJECT_DIR/SQ_BL.txt"
 echo "\u001b[34;1m--------Iteration "$a" -------->> \u001b[0m"
done

input=../"$PROJECT_DIR/SQ_BL.txt"
export sq_bl=()
while IFS= read -r line
do
 sq_bl+=($line)
done < "$input"
cd ..
pkill wrapper
sleep 20s

cd $PROJECT_DIR

# python3 plots.py $N_ITER $PROJECT "${intraj_daa[@]}" "${jji_dda[@]}"
python3 ../../plots.py $N_ITER $PROJECT $CURRDIR "${intraj_daa[@]}" "${jji_dda[@]}" "${sq_dda[@]}"   "${intraj_cfg[@]}" "${jji_cfg[@]}" "${intraj_cfgdaa[@]}" "${jji_cfgdda[@]}" "${intraj_daa_ss[@]}" "${jji_dda_ss[@]}"  "${intraj_cfg_ss[@]}" "${jji_cfg_ss[@]}" "${intraj_cfgdaa_ss[@]}" "${jji_cfgdda_ss[@]}"  "${intraj_bl[@]}" "${jji_bl[@]}" "${sq_bl[@]}" "${intraj_npa[@]}" "${intraj_npa_ss[@]}" "${intraj_cfgnpa[@]}" "${intraj_cfgnpa_ss[@]}" "${sq_npa[@]}" 
cd ../..

echo '\u001b[33;1m[INFO] SAVING RAW DATA in /raw \u001b[0m'
mkdir "$PROJECT_DIR/raw"
cd "$PROJECT_DIR/raw"
echo "${intraj_daa[@]}" > intraj_dda.txt
echo "${jji_dda[@]}" > jji_dda.txt
echo "${sq_dda[@]}" > sq_dda.txt
echo "${intraj_cfg[@]}" > intraj_cfg.txt
echo "${jji_cfg[@]}" > jji_cfg.txt
echo "${intraj_cfgdaa[@]}" > intraj_cfgdaa.txt
echo "${jji_cfgdda[@]}" > jji_cfgdda.txt
echo "${intraj_daa_ss[@]}" > intraj_daa_ss.txt
echo "${jji_dda_ss[@]}" > jji_dda_ss.txt
echo "${intraj_cfg_ss[@]}" > intraj_cfg_ss.txt
echo "${jji_cfg_ss[@]}" > jji_cfg_ss.txt
echo "${intraj_cfgdaa_ss[@]}" > intraj_cfgdaa_ss.txt
echo "${jji_cfgdda_ss[@]}" > jji_cfgdda_ss.txt
echo "${jji_bl[@]}" > jji_bl.txt
echo "${sq_bl[@]}" > sq_bl.txt
echo "${intraj_npa[@]}" > intraj_npa.txt
echo "${intraj_npa_ss[@]}" > intraj_npa_ss.txt
echo "${intraj_cfgnpa[@]}" > intraj_cfgnpa.txt
echo "${intraj_cfgnpa_ss[@]}" > intraj_cfgnpa_ss.txt
echo "${sq_npa[@]}" > sq_npa.txt
cd ../..


