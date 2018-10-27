//
// Created by Daniel on 16/09/2018.
//

#ifndef RAIZCALCULATOR_EXAMPLEHEADER_H
#define RAIZCALCULATOR_EXAMPLEHEADER_H

#include <pthread.h>

typedef struct {
    unsigned long  width;
    unsigned long weight;
    unsigned char *data;
} buffer;

void direct_init();

#endif //RAIZCALCULATOR_EXAMPLEHEADER_H
