#ifndef TRANSLATION_H
#define TRANSLATION_H

#include <QObject>

class Translation : public QObject
{
    Q_OBJECT
public:
    //explicit Translation(QObject *parent = 0);
    explicit Translation(QObject *parent = 0,
                         QChar input = 'A',
                         QList<QChar> *output = new QList<QChar>());
    QChar inputCharacter;
    QList<QChar> *outputCharacter;
    QString translate();
    QString toString();

signals:
    
public slots:
    
};

#endif // TRANSLATION_H
