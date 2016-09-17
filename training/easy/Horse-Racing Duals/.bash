# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.


insert(){
    declare -a array=("${!1}")
    local element=$2
    local pos=$3
    local begin=("${array[@]::$pos}")
    local end=("${array[@]:$pos}")
    local coco=(${begin[@]} $element ${end[@]})
    echo "${coco[@]}"
}
echo tageule >&2
echo $(($(date +%s%N)/1000000)) >&2

javac

quicksort() {
    # sorts the positional elements wrt alphanumerical sort
    # return is in array quicksort_ret
    if (($#==0)); then
        quicksort_ret=()
        return
    fi
    local pivot=$1 greater=() lower=() i
    shift
    for i; do
        if [[ "$i" -le "$pivot" ]]; then
            lower+=( "$i" )
        else
            greater+=( "$i" )
        fi
    done
    quicksort "${greater[@]}"
    greater=( "${quicksort_ret[@]}" )
    quicksort "${lower[@]}"
    quicksort_ret+=( "$pivot" "${greater[@]}" )
}

read N
read Pi
chevaux[0]=$Pi


for (( i=1; i<N; i++ )); do
    read Pi
    # for (( j=0; j<i; j++ )); do
    #     ok='0'
    #     if [ ${chevaux[j]} -ge $Pi ]
    #     then
    #         coco=$(insert chevaux[@] $Pi $j)
    #         chevaux=(${coco[@]})
    #         ok='1'
    #         break
    #     fi
    #     if [ $ok = '0' ]
    #     then
    #         chevaux[$i]=$Pi
    #     fi
    # done
    echo $i >&2
    chevaux[$i]=$Pi
done

echo tageule >&2
echo $(($(date +%s%N)/1000000)) >&2

quicksort "${chevaux[@]}"

echo tageule >&2
echo $(($(date +%s%N)/1000000)) >&2

min=1000
for (( i=0; i<N-1; i++ )); do
    test=$((${quicksort_ret[$i+1]} - ${quicksort_ret[$i]}))
    if [ $test -lt $min ]
    then
        min=$test
    fi
done

echo $min


