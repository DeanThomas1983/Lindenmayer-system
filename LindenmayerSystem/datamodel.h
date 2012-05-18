#ifndef DATAMODEL_H
#define DATAMODEL_H

#include <QObject>
#include <translation.h>

class DataModel : public QObject
{
    Q_OBJECT
public:
    explicit DataModel(QObject *parent = 0);
    QString *inputString;
    QList<Translation> *rules;

signals:
    
public slots:
    
};

#endif // DATAMODEL_H
