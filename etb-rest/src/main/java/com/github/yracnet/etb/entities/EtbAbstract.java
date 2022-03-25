/**
 *   _   _ _     _         ____         __ _
 *  | | | (_)___| | ____ _/ ___|  ___  / _| |_
 *  | |_| | / __| |/ / _` \___ \ / _ \| |_| __|
 *  |  _  | \__ \   < (_| |___) | (_) |  _| |_
 *  |_| |_|_|___/_|\_\__,_|____/ \___/|_|  \__|
 *
 *  Copyright © 2022 HiskaSoft
 *  http://www.hiskasoft.com/licenses/LICENSE-2.0
 */
package com.github.yracnet.etb.entities;

import java.io.Serializable;
import lombok.Data;

@Data
//@ToString
//@EqualsAndHashCode
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@EntityListeners({EtbAuditorListener.class})
//@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
public abstract class EtbAbstract implements Serializable {
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @Column(name = "ID")
//    private UUID id;
//    @Column(name = "AUD_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;
//    @Version
//    @Column(name = "AUD_VERSION")
//    private long version;
}
