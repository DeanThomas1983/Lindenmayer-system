#include "datamodel.h"
#include <QDebug>

DataModel::DataModel(QObject *parent) :
    QObject(parent)
{
    QList<QChar> outputs;

    outputs << 'A' << 'B' << 'C';

    Translation *t = new Translation(this, 'A', &outputs);

    qDebug() << t->translate();
}

QString DataModel::getListOfRules()
{
    QString result = "";

    for (int i = 0; i < rules->count(); i++)
    {
        Translation *t = rules->at(i);

        result.append(t->toString());
    }

    return result;
}
