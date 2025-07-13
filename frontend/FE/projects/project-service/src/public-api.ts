/*
 * Public API Surface of project-service
 */
//MODELLI
export * from './lib/models/candidaturaDTO.model';
export * from './lib/models/bandoDTO.model';
export * from './lib/models/enteDTO.model';
//CANDIDATURE
export * from './lib/candidature/candidatura-list/candidatura-list'; 
export * from './lib/candidature/candidature.routes';
export * from './lib/candidature/candidatura.service';

//BANDI
export * from './lib/bando/bandi-list/bandi-list';
export * from './lib/bando/bandi.routes';
export * from './lib/bando/bandoService';

//ENTI
export * from './lib/ente/enti-list/enti-list';
export * from './lib/ente/ente-service';
