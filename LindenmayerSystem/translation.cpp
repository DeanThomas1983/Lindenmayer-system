#include "translation.h"

/*
Translation::Translation(QObject *parent) :
    QObject(parent)
{

}
*/
Translation::Translation(QObject *parent, QChar input, QList<QChar> *output) :
    QObject(parent)
{
    this->inputCharacter = input;
    this->outputCharacter = output;
}

QString Translation::translate()
{
    QString result = "";

    for (int i = 0; i < outputCharacter->count(); i++)
    {
        result.append(outputCharacter->at(i));
    }

    return result;
}
