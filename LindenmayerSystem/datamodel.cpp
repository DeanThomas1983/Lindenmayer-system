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
